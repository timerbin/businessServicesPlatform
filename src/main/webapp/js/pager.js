(function ($) {
	$.fn.pager = function (options) {
		$.extend({ pagenumber: 1, pagecount: 1, buttonClickCallback: null }, options);

		var pagenumber = parseInt(options.pagenumber,10);
		var pagecount = parseInt(options.pagecount,10);
		var buttonClickCallback = options.buttonClickCallback;

		$(this).empty().append('<span id="page_count">共' + pagecount + '页</span>');

		var $firstbutton = $('<a href="javascript:void(0);" class="prev-links current">首页</a>');
		pagenumber <= 1 ? $firstbutton.removeClass('current') : $firstbutton.click(function () {
			buttonClickCallback(1);
		});

		$(this).append($firstbutton);

		var startPoint = 1;
		var endPoint = 9;

		if (pagenumber > 4) {
			startPoint = pagenumber - 4;
			endPoint = pagenumber + 4;
		}

		if (endPoint > pagecount) {
			startPoint = pagecount - 8;
			endPoint = pagecount;
		}

		if (startPoint < 1) {
			startPoint = 1;
		}

		for (var page = startPoint; page <= endPoint; page++) {

			var currentButton = $('<a href="javascript:void(0);">' + (page) + '</a>');

			page === pagenumber ? currentButton.addClass('active') : currentButton.click(function () {
				buttonClickCallback(parseInt(this.firstChild.data));
			});
			currentButton.appendTo($(this));
		}

		var $lastbutton = $('<a href="javascript:void(0);" class="next-links current">末页</span>');
		pagenumber >= pagecount ? $lastbutton.removeClass('current') : $lastbutton.click(function () {
			buttonClickCallback(pagecount);
		});

		$(this).append($lastbutton);
	};

})(jQuery);


var cur_page = $("#curPage").val();
var page_size = $("#pageSize").val();
var page_count = $("#pageCount").val();
jQuery("#pager").pager({pagenumber: cur_page, pagecount: page_count, buttonClickCallback: change_page });
 
//翻页
function change_page(cur_page) {
    jQuery("#page").val(cur_page);
    jQuery("#allCompany").submit();
}
