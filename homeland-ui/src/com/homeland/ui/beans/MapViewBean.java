package com.homeland.ui.beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polygon;

import com.homeland.ui.constants.IMap;
import com.homeland.ui.models.AddressDTO;
import com.homeland.ui.models.BuildingMAP;
import com.homeland.ui.services.AddressService;
import com.homeland.ui.utils.MapUtil;
import com.homeland.ui.utils.Messages;
import com.homeland.ui.utils.StringUtil;

@ManagedBean
@ViewScoped
public class MapViewBean implements Serializable {

	private static final long serialVersionUID = 1L;

	final String DEFAULT_CENTER = "41.328861, 19.818140";

	@ManagedProperty(value = "#{nav}")
	NavigationBean nav;

	boolean renderBack = false;

	MapModel mapModel;
	String centerMap;
	String zoomMap;

	Integer unitId;

	List<AddressDTO> addresses;

	public NavigationBean getNav() {
		return nav;
	}

	public void setNav(NavigationBean nav) {
		this.nav = nav;
	}

	public boolean isRenderBack() {
		return renderBack;
	}

	public void setRenderBack(boolean renderBack) {
		this.renderBack = renderBack;
	}

	public MapModel getMapModel() {
		return mapModel;
	}

	public void setMapModel(MapModel mapModel) {
		this.mapModel = mapModel;
	}

	public String getCenterMap() {
		return centerMap;
	}

	public void setCenterMap(String centerMap) {
		this.centerMap = centerMap;
	}

	public String getZoomMap() {
		return zoomMap;
	}

	public void setZoomMap(String zoomMap) {
		this.zoomMap = zoomMap;
	}

	public List<AddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}

	@PostConstruct
	public void load() {
		this.centerMap = DEFAULT_CENTER;
		this.zoomMap = "18";
	}

	public void init() {
		this.addresses = null;
		this.unitId = null;

		this.mapModel = new DefaultMapModel();
		Polygon polygon = new Polygon();
		mapModel.addOverlay(polygon);

		String bid = nav.getParam("bid");
		if (StringUtil.isValid(bid)) {

			BigInteger buildingId = new BigInteger(bid);
			addBuilding(buildingId);

			renderBack = true;
		}

	}

	public void addBuilding(BigInteger buildingId) {
		BuildingMAP bm = new AddressService().getBuildingMapById(buildingId);
		if (bm == null)
			return;

		this.unitId = bm.getUnitId();
		Polygon polygon = new MapUtil().toPolygon(bm.getShape());
		if (polygon != null) {
			polygon.setId(String.valueOf(bm.getBuildingId()));
			polygon.setData(bm.getBuildingId());

			polygon.setFillColor(IMap.BUILDING_FILL_COLOR);
			polygon.setStrokeColor(IMap.BUILDING_STROKE_COLOR);

			polygon.setFillOpacity(IMap.BUILDING_FILL_OPACITY);

			polygon.setStrokeOpacity(IMap.BUILDING_STROKE_OPACITY);
			polygon.setStrokeWeight(IMap.BUILDING_STROKE_WHEIGHT);
			mapModel.addOverlay(polygon);
		}

		Marker m = new Marker(new MapUtil().toLatLng(bm.getCenter()), "Ndertesa: " + bm.getBuildingCode());
		m.setData(bm.getBuildingId());
		m.setIcon("http://maps.google.com/mapfiles/ms/micons/green-dot.png");
		mapModel.addOverlay(m);

		this.centerMap = new MapUtil().toMapCoord(bm.getCenter());

	}

	public void addUnitBuildings() {

		List<BuildingMAP> buildings = new AddressService().getBuildingsMapByUnitId(unitId);

		if (buildings != null && !buildings.isEmpty()) {
			for (BuildingMAP bm : buildings) {
				Polygon polygon = new MapUtil().toPolygon(bm.getShape());

				if (polygon != null) {
					polygon.setId(String.valueOf(bm.getBuildingId()));
					polygon.setData(bm.getBuildingId());

					polygon.setFillColor(IMap.BUILDING_FILL_COLOR);
					polygon.setStrokeColor(IMap.BUILDING_STROKE_COLOR);

					polygon.setFillOpacity(IMap.BUILDING_FILL_OPACITY);

					polygon.setStrokeOpacity(IMap.BUILDING_STROKE_OPACITY);
					polygon.setStrokeWeight(IMap.BUILDING_STROKE_WHEIGHT);

					mapModel.addOverlay(polygon);

				}
			}
			
			this.zoomMap = "16";
			
		}

	}

	public void onOverlaySelect(OverlaySelectEvent event) {
		
		try {
			Marker m = (Marker) event.getOverlay();
			onMarkerSelect(m);
			return;
		} catch (Exception e) {
		}

		try {
			Polygon p = (Polygon) event.getOverlay();
			onPolygonSelect(p);
			return;
		} catch (Exception e) {
		}

	}

	public void onMarkerSelect(Marker m) {
		
		if (m == null) {
			Messages.throwFacesMessage("Pika e zgjedhur nuk ka te dhena", 3);
			return;
		}

		BigInteger bid = (BigInteger) m.getData();
		
		this.addresses = new AddressService().getAddressByBuildingId(bid);

		if (addresses != null && !addresses.isEmpty()) {
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('addWid').show();");
			current.ajax().update("add_dlg");
		} else {
			Messages.throwFacesMessage("Nuk ka banore te regjistruar ne kete ndertese", 2);
		}

	}

	public void onPolygonSelect(Polygon p) {
		
		if (p == null) {
			Messages.throwFacesMessage("Zona e zgjedhur nuk ka te dhena", 3);
			return;
		}

		BigInteger bid = (BigInteger) p.getData();

		this.addresses = new AddressService().getAddressByBuildingId(bid);

		if (addresses != null && !addresses.isEmpty()) {
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('addWid').show();");
			current.ajax().update("add_dlg");
		} else {
			Messages.throwFacesMessage("Nuk ka banore te regjistruar ne kete ndertese", 2);
		}

	}

}
