package olympus.flock.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller

public class Controller {

  private boolean autoRespond = false;

  private String responseText = "";

  @RequestMapping(value = "/enable", method = RequestMethod.POST)
  @ResponseBody
  public void setAutoRespond(@RequestBody Map<String, String> req) {
    this.autoRespond = true;
    this.responseText = req.get("text");
  }

  @RequestMapping(value = "/disable", method = RequestMethod.POST)
  @ResponseBody
  public void unsetAutoRespond() {
    this.autoRespond = false;
  }

  @RequestMapping(value = "/listen", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, String> respond(@RequestBody Map<String, Object> req) {
    if (this.autoRespond && ((String)req.get("text")).toLowerCase().contains("taha")) {
      HashMap<String, String> map = new HashMap<>();
      map.put("text", responseText);
      return map;
    }
    return null;
  }
}
