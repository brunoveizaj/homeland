package com.homeland.ui.utils;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Polygon;

public class MapUtil {

	public LatLng toLatLng(String point)
	{
		if(!StringUtil.isValid(point)) return null;
		
		String[] coords = point.trim().split(" ", -1);
		if(coords.length == 2)
		{
			Double coord1 = Double.valueOf(coords[1].trim());
			Double coord2 = Double.valueOf(coords[0].trim());
			
			LatLng latLng = new LatLng(coord1, coord2);
			
			return latLng;
		}
		
		return null;
		
	}
	
	
	public List<LatLng> shapeToListLatLng(String shape)
	{
		if(!StringUtil.isValid(shape)) return null;
		
		String[] points = shape.split(",", -1);
		if(points != null && points.length > 0)
		{
			List<LatLng> list = new ArrayList<>();
			for(String p : points)
			{
				LatLng ll = toLatLng(p);
				if(ll != null)
				{
					list.add(ll);
				}
			}
			
			return list;
		}
		
		return null;
	}
	
	public Polygon toPolygon(String shape)
	{
		
		if(!StringUtil.isValid(shape)) return null;
		
		String[] points = shape.split(",", -1);
		
		if(points != null && points.length > 0)
		{
			Polygon pol = new Polygon();
			for(String p : points)
			{
				LatLng ll = toLatLng(p);
				if(ll != null)
				{
					pol.getPaths().add(ll);
				}
			}
			
			return pol;
		}
		
		return null;
		
	}
	
	public String toMapCoord(String point)
	{
		if(!StringUtil.isValid(point)) return null;
		
		String[] coords = point.trim().split(" ", -1);
		if(coords.length == 2)
		{
			String coord1 = coords[0].trim();
			String coord2 = coords[1].trim();
			
			return coord2 + "," + coord1;
		}
		
		return null;
	}
	
	
	
	
}
