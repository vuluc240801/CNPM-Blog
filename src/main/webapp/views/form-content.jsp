<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div id="page-wrapper">
<h2>Add Content</h2>
<hr />
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Contents Form Elements</h3>
  </div>

  <div class="panel-body">
    <form
      action="#"
      accept-charset="UTF-8"
      role="form"
      id="validate_add_content_form"
    >
      <fieldset>
        <label>Title</label>
        <div class="form-group">
          <input
            class="form-control"
            placeholder="Enter the title"
            name="title"
            type="text"
          />
        </div>

        <label>Brief</label>
        <div class="form-group">
          <textarea class="form-control" name="brief" rows="3"></textarea>
        </div>

        <label>Content</label>
        <div class="form-group">
          <textarea class="form-control" name="content" rows="6"></textarea>
        </div>
        <button class="btn btn-default" type="submit" value="Add">
          Submit Button
        </button>
        <button class="btn btn-default" type="reset">Reset Button</button>
      </fieldset>
    </form>
  </div>
</div>
</div>