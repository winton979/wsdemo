package testws;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/system")
public class SimpleController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	/**
	 * 主动调用。比如服务器发送通知到特定的用户
	 * @throws IOException
	 */
	@GetMapping("/notifyall")
	public void notifyall() throws IOException {
		CopyOnWriteArraySet<Ws> socketSet = Ws.webSocketSet;
		for (Ws ws : socketSet) {
			ws.sendMessage("shabi");
		}
	}
}