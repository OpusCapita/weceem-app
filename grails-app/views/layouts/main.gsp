<!--
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title><g:layoutTitle default="Weceem"/></title>
    <jq:resources/>
    <jqui:resources/>
    <blueprint:resources plugin="fancy-type, buttons"/>

    <link rel="shortcut icon" href=""/>
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'layout.css')}"></link>
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'default.css')}"></link>
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'weceem.css')}"></link>
    <g:layoutHead/>
  </head>
  <body>
  <div  align="center">
    <table border="0px" cellspacing="0" cellpadding="0" width="840" height="380" align="center">
      <tbody>
        <tr>
          <td width="100%" valign="top" id="link">
            <g:link controller="portal">Administration Editor</g:link>
          </td>
        </tr>

        <tr>
          <td height="100%" width="100%" valign="top" id="fullContent">
             <g:layoutBody/>
          </td>
        </tr>
      </tbody>
    </table>
</div>
</body>
</html>