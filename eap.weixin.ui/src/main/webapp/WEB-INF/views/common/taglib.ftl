<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign fmt=JspTaglibs["http://java.sun.com/jsp/jstl/fmt"]>
<#assign fn=JspTaglibs["http://java.sun.com/jsp/jstl/functions"]>
<#assign decorator=JspTaglibs["http://www.opensymphony.com/sitemesh/decorator"]>
<#assign page=JspTaglibs["http://www.opensymphony.com/sitemesh/page"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>
<#assign f=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign shiro=JspTaglibs["http://shiro.apache.org/tags"]>
<#assign e=JspTaglibs["/WEB-INF/taglib/eap.tld"]>
<@e.useEnv var="env" />
<@e.useConstants var="Env" className="eap.WebEnv" />
<@e.useConstants var="P" className="me.cungu.footmark.module.P" />