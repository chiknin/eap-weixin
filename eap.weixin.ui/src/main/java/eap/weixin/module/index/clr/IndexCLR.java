package eap.weixin.module.index.clr;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eap.base.BaseController;
import eap.weixin.module.P;

@Controller
public class IndexCLR extends BaseController {
	
	@RequestMapping(value=P.INDEX)
	public String index(Model model, HttpServletRequest request) {
		return "index";
	}
}