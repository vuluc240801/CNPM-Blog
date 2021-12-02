$(document).ready(function () {
  $('#dataTable').DataTable(
	{
        "lengthMenu": [[10], [10]],
		searching: false,


    }
);
  $('#dataTable td').css('white-space','initial');
  $('.dataTables_length').addClass('bs-select');
});