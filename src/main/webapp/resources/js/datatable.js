$(document).ready(function () {
  $('#dataTable').DataTable(
	{
		deferRender:    true,
        scrollX: 				true,
        scrollY:        200,
        scrollCollapse: true,
        scroller:       true,
        searching: 			false,
        paging: 				true,
        info: 					false,
        "lengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]],
    }
);
  $('#dataTable td').css('white-space','initial');
  $('.dataTables_length').addClass('bs-select');
});