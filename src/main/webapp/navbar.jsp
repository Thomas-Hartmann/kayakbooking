<nav class="navbar navbar-default">
  <div class="container-fluid">

      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="User name">
          <input type="text" class="form-control" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-default">Log in</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
          <%if(request.getAttribute("user")!=null){
              User user1 = (User)request.getAttribute("user");
              out.print("<li><a>Logged in as: "+user1.getName()+"</a></li>");
          }
              
          %>
<!--        <li class="dropdown example">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>-->
      </ul>
  </div><!-- /.container-fluid -->
</nav>
