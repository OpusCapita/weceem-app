<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <title>Access Denied!</title>
  <meta name="layout" content="main">
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css">
</head>
<body>
  <p>We're sorry, but you are not authorized to
     perform the requested operation.</p>
  <g:renderException exception="${exception}" />
</body>
</html>
