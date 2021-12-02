var viewContentBar = document.querySelector('#view_content');
var formContentBar = document.querySelector('#form_content');
var editProfileBar = document.querySelector('#edit_profile');
var viewContent = document.querySelector('#page-wrapper');
viewContentBar.onclick = function(e) {
    viewContent.innerHTML = '<h2 >Loading</h2>';
    e.preventDefault();
    var serviceURL = '/WebMVCProject/ViewContentServlet';
    var model = null;
    setTimeout(function() {
        $.ajax({
            type: "GET",
            url: serviceURL,
            data: JSON.stringify(model),
            contentType: "application/json; charset=utf-8",
            dataType: 'html',
            success: function(data) {
                $('body').load(serviceURL);
            },
            error: function(data, errorThrown) {
                alert(errorThrown);
            }
        });
    }, 3000);
}
formContentBar.onclick = function(e) {
    viewContent.innerHTML = '<h2 >Loading</h2>';
    e.preventDefault();
    var serviceURL = '/WebMVCProject/CreateAndEditContentServlet?mode=0';
    var model = null;
    setTimeout(function() {
        $.ajax({
            type: "GET",
            url: serviceURL,
            data: JSON.stringify(model),
            contentType: "application/json; charset=utf-8",
            dataType: 'html',
            success: function(data) {
                $('body').load(serviceURL);
            },
            error: function(data, errorThrown) {
                alert(errorThrown);
            }
        });
    }, 3000);
}
editProfileBar.onclick = function(e) {
    viewContent.innerHTML = '<h2 >Loading</h2>';
    e.preventDefault();
    var serviceURL = '/WebMVCProject/Profile';
    var model = null;
    setTimeout(function() {
        $.ajax({
            type: "GET",
            url: serviceURL,
            data: JSON.stringify(model),
            contentType: "application/json; charset=utf-8",
            dataType: 'html',
            success: function(data) {
                $('body').load(serviceURL);
            },
            error: function(data, errorThrown) {
                alert(errorThrown);
            }
        });
    }, 3000);
}