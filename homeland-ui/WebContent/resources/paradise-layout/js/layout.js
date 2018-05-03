/** 
 * PrimeFaces Paradise Layout
 */
PrimeFaces.widget.Paradise = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.wrapper = $(document.body).children('.layout-wrapper');
        this.topbar = this.wrapper.children('.topbar');
        this.menuWrapper = this.wrapper.find('> .layout-main > .layout-menu-wrapper');
        this.menuButton = $('#menu-button');
        this.userDisplay = $('#user-display');
        this.topbarMenu = $('#topbar-menu');
        this.topbarLinks = this.topbarMenu.find('a');
        this.menu = this.menuWrapper.find('ul.layout-menu');
        this.menulinks = this.menu.find('a');
        this.expandedMenuitems = this.expandedMenuitems || [];     
        this.nano = this.menuWrapper.children('.nano');
        
        this.bindEvents();
        
        if(!this.isSlim()) {
            this.restoreMenuState();
        }
    },
    
    bindEvents: function() {
        var $this = this;
        
        if(!this.wrapper.hasClass('layout-menu-slim')) {
            this.nano.nanoScroller();
        }
        
        this.menuWrapper.on('click', function(e) {
            $this.menuClick = true;
        });
        
        this.menuButton.on('click', function(e) {
            if($this.isMobile()) {
                $this.wrapper.toggleClass('layout-menu-active');
                
                if($this.wrapper.hasClass('layout-menu-active'))
                    $this.wrapper.append('<div class="layout-mask"></div>');
                else
                    $this.wrapper.children('.layout-mask').remove();
                
            }
            else {
                if($this.wrapper.hasClass('layout-menu-overlay'))
                    $this.wrapper.toggleClass('layout-menu-overlay-active');
                else
                    $this.wrapper.toggleClass('layout-menu-static-inactive');
            }
            
            $this.nano.nanoScroller();
            
            $this.menuButtonClick = true;
            e.preventDefault();
            setTimeout(function() {
                $(window).trigger('resize');
            }, 320);
        });
        
        this.menulinks.off('click mouseenter').on('click', function(e) {
            var link = $(this),
            item = link.parent(),
            submenu = item.children('ul');
            
            if($this.isSlim() && item.parent().hasClass('layout-menu')) {
                if(item.hasClass('active-menuitem')) {
                    if(submenu.length) {
                        $this.removeMenuitem(item.attr('id'));
                        item.removeClass('active-menuitem');
                        submenu.hide();
                        $this.menuHoverActive = false;
                    }
                }
                else {
                    item.addClass('active-menuitem');
                    $this.addMenuitem(item.attr('id'));
                    $this.deactivateItems(item.siblings(), false);
                    submenu.show();
                    $this.menuHoverActive = true;
                }
            }
            else {
                if(item.hasClass('active-menuitem')) {
                    if(submenu.length) {
                        $this.removeMenuitem(item.attr('id'));
                        item.removeClass('active-menuitem');
                        submenu.slideUp();
                    }
                }
                else {
                    $this.addMenuitem(item.attr('id'));
                    $this.deactivateItems(item.siblings(), true);
                    $this.activate(item);
                }
            }

            setTimeout(function() {
                if(!$this.isSlim()) {
                    $this.nano.nanoScroller();
                }
            }, 500);
                                    
            if(submenu.length) {
                e.preventDefault();
            }
        }).on('mouseenter', function(e) {
            var link = $(this),
            item = link.parent(),
            submenu = item.children('ul');
    
            if($this.isSlim() && item.parent().hasClass('layout-menu') && $this.menuHoverActive && !item.hasClass('active-menuitem')) {
                $this.deactivateItems($this.menu.children('.active-menuitem'), false);
                item.addClass('active-menuitem');
                submenu.show();
            }
        });
        
        this.userDisplay.on('click', function(e) {
            $this.topbarMenuButtonClick = true;

            if($this.topbarMenu.hasClass('topbar-menu-visible')) {
                $this.hideTopBar();
            }
            else {
                $this.topbarMenu.addClass('topbar-menu-visible fadeInDown');
            }
                        
            e.preventDefault();
        });
        
        this.topbarLinks.on('click', function(e) {
            var link = $(this),
            item = link.parent(),
            submenu = link.next();
            
            $this.topbarLinkClick = true;
            item.siblings('.menuitem-active').removeClass('menuitem-active');
            
            if(item.hasClass('menuitem-active')) {
                item.removeClass('menuitem-active');
                link.next('ul').slideUp();
            }
            else {
                item.addClass('menuitem-active');
                link.next('ul').slideDown();
            }
            
            if(submenu.length) {
                e.preventDefault();   
            }
        });
        
        $(document.body).off('click').on('click', function() {                   
            if(!$this.topbarMenuButtonClick && !$this.topbarLinkClick) {
                $this.hideTopBar();
            }
            
            if(!$this.menuClick && $this.isSlim()) {
                $this.deactivateItems($this.menu.children('.active-menuitem'), false);
                $this.menuHoverActive = false;
            }
            
            if(($this.wrapper.hasClass('layout-menu-overlay-active') || $this.wrapper.hasClass('layout-menu-active')) && (!$this.menuClick && !$this.menuButtonClick)) {
                $this.wrapper.removeClass('layout-menu-overlay-active layout-menu-active');
                $this.wrapper.children('.layout-mask').remove();
            }
            
            $this.topbarLinkClick = false;
            $this.topbarMenuButtonClick = false;
            $this.menuClick = false;
            $this.menuButtonClick = false;
        });
        
    },
    
    activate: function(item) {
        var submenu = item.children('ul');
        item.addClass('active-menuitem');

        if(submenu.length) {
            submenu.slideDown();
        }
    },
    
    deactivate: function(item) {
        var submenu = item.children('ul');
        item.removeClass('active-menuitem');
        
        if(submenu.length) {
            submenu.hide();
        }
    },
        
    deactivateItems: function(items, animate) {
        var $this = this;
        
        for(var i = 0; i < items.length; i++) {
            var item = items.eq(i),
            submenu = item.children('ul');
            
            if(submenu.length) {
                if(item.hasClass('active-menuitem')) {
                    var activeSubItems = item.find('.active-menuitem');
                    item.removeClass('active-menuitem');
                    
                    if(animate) {
                        submenu.slideUp('normal', function() {
                            $(this).parent().find('.active-menuitem').each(function() {
                                $this.deactivate($(this));
                            });
                        });
                    }
                    else {
                        submenu.hide();
                        item.find('.active-menuitem').each(function() {
                            $this.deactivate($(this));
                        });
                    }
                    
                    $this.removeMenuitem(item.attr('id'));
                    activeSubItems.each(function() {
                        $this.removeMenuitem($(this).attr('id'));
                    });
                }
                else {
                    item.find('.active-menuitem').each(function() {
                        var subItem = $(this);
                        $this.deactivate(subItem);
                        $this.removeMenuitem(subItem.attr('id'));
                    });
                }
            }
            else if(item.hasClass('active-menuitem')) {
                $this.deactivate(item);
                $this.removeMenuitem(item.attr('id'));
            }
        }
    },
    
    removeMenuitem: function (id) {
        this.expandedMenuitems = $.grep(this.expandedMenuitems, function (value) {
            return value !== id;
        });
        this.saveMenuState();
    },
    
    addMenuitem: function (id) {
        if ($.inArray(id, this.expandedMenuitems) === -1) {
            this.expandedMenuitems.push(id);
        }
        this.saveMenuState();
    },
    
    saveMenuState: function() {
        $.cookie('paradise_expandeditems', this.expandedMenuitems.join(','), {path: '/'});
    },
    
    clearMenuState: function() {
        $.removeCookie('paradise_expandeditems', {path: '/'});
    },
    
    restoreMenuState: function() {
        var menucookie = $.cookie('paradise_expandeditems');
        if (menucookie) {
            this.expandedMenuitems = menucookie.split(',');
            for (var i = 0; i < this.expandedMenuitems.length; i++) {
                var id = this.expandedMenuitems[i];
                if (id) {
                    var menuitem = $("#" + this.expandedMenuitems[i].replace(/:/g, "\\:"));
                    menuitem.addClass('active-menuitem');
                    
                    var submenu = menuitem.children('ul');
                    if(submenu.length) {
                        submenu.show();
                    }
                }
            }
        }
    },
    
    hideTopBar: function() {
        var $this = this;
        this.topbarMenu.addClass('fadeOutUp');
        
        setTimeout(function() {
            $this.topbarMenu.removeClass('fadeOutUp topbar-menu-visible');
        },500);
    },
    
    isMobile: function() {
        return window.innerWidth <= 640;
    },
    
    isSlim: function() {
        return !this.isMobile() && this.wrapper.hasClass('layout-menu-slim');
    }
});

/*!
 * jQuery Cookie Plugin v1.4.1
 * https://github.com/carhartl/jquery-cookie
 *
 * Copyright 2006, 2014 Klaus Hartl
 * Released under the MIT license
 */
(function (factory) {
	if (typeof define === 'function' && define.amd) {
		// AMD (Register as an anonymous module)
		define(['jquery'], factory);
	} else if (typeof exports === 'object') {
		// Node/CommonJS
		module.exports = factory(require('jquery'));
	} else {
		// Browser globals
		factory(jQuery);
	}
}(function ($) {

	var pluses = /\+/g;

	function encode(s) {
		return config.raw ? s : encodeURIComponent(s);
	}

	function decode(s) {
		return config.raw ? s : decodeURIComponent(s);
	}

	function stringifyCookieValue(value) {
		return encode(config.json ? JSON.stringify(value) : String(value));
	}

	function parseCookieValue(s) {
		if (s.indexOf('"') === 0) {
			// This is a quoted cookie as according to RFC2068, unescape...
			s = s.slice(1, -1).replace(/\\"/g, '"').replace(/\\\\/g, '\\');
		}

		try {
			// Replace server-side written pluses with spaces.
			// If we can't decode the cookie, ignore it, it's unusable.
			// If we can't parse the cookie, ignore it, it's unusable.
			s = decodeURIComponent(s.replace(pluses, ' '));
			return config.json ? JSON.parse(s) : s;
		} catch(e) {}
	}

	function read(s, converter) {
		var value = config.raw ? s : parseCookieValue(s);
		return $.isFunction(converter) ? converter(value) : value;
	}

	var config = $.cookie = function (key, value, options) {

		// Write

		if (arguments.length > 1 && !$.isFunction(value)) {
			options = $.extend({}, config.defaults, options);

			if (typeof options.expires === 'number') {
				var days = options.expires, t = options.expires = new Date();
				t.setMilliseconds(t.getMilliseconds() + days * 864e+5);
			}

			return (document.cookie = [
				encode(key), '=', stringifyCookieValue(value),
				options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
				options.path    ? '; path=' + options.path : '',
				options.domain  ? '; domain=' + options.domain : '',
				options.secure  ? '; secure' : ''
			].join(''));
		}

		// Read

		var result = key ? undefined : {},
			// To prevent the for loop in the first place assign an empty array
			// in case there are no cookies at all. Also prevents odd result when
			// calling $.cookie().
			cookies = document.cookie ? document.cookie.split('; ') : [],
			i = 0,
			l = cookies.length;

		for (; i < l; i++) {
			var parts = cookies[i].split('='),
				name = decode(parts.shift()),
				cookie = parts.join('=');

			if (key === name) {
				// If second argument (value) is a function it's a converter...
				result = read(cookie, value);
				break;
			}

			// Prevent storing a cookie that we couldn't decode.
			if (!key && (cookie = read(cookie)) !== undefined) {
				result[name] = cookie;
			}
		}

		return result;
	};

	config.defaults = {};

	$.removeCookie = function (key, options) {
		// Must not alter options, thus extending a fresh object...
		$.cookie(key, '', $.extend({}, options, { expires: -1 }));
		return !$.cookie(key);
	};

}));

/* Issue #924 is fixed for 5.3+ and 6.0. (compatibility with 5.3) */
if(window['PrimeFaces'] && window['PrimeFaces'].widget.Dialog) {
    PrimeFaces.widget.Dialog = PrimeFaces.widget.Dialog.extend({
        
        enableModality: function() {
            this._super();
            $(document.body).children(this.jqId + '_modal').addClass('ui-dialog-mask');
        },
        
        syncWindowResize: function() {}
    });
}
    

