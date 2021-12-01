$(document).ready(function () {
  $('#dataTable').DataTable(
	{
        "lengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]],
		searching: false,


    }
);
  $('#dataTable td').css('white-space','initial');
  $('.dataTables_length').addClass('bs-select');
});