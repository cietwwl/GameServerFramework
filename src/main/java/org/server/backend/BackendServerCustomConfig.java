package org.server.backend;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 自定义后台集合配置
 *
 * @author Hxms
 */
public class BackendServerCustomConfig extends HashMap<String, Object> {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8178399589711846783L;
	// 日志记录器
    static final Logger logger = LoggerFactory.getLogger(BackendServer.class);

    @SuppressWarnings("unchecked")
    protected BackendServerCustomConfig(Document document) {
        try {
            NodeList nodeList = document.getElementsByTagName("CustomConfig");
            if (nodeList == null || nodeList.getLength() == 0) {
                return;
            }
            HashMap<String, Object> result = (HashMap<String, Object>) parseConfigMap(nodeList).get("CustomConfig");
            this.putAll(result);
        } catch (Exception e) {
        }
    }

    final HashMap<String, Object> parseConfigMap(NodeList nodeList) {
        HashMap<String, Object> result = new HashMap<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element e = (Element) node;
                HashMap<String, Object> nodeMap = null;
                if (e.hasChildNodes() && !(nodeMap = parseConfigMap(e.getChildNodes())).isEmpty()) {
                    result.put(e.getTagName(), nodeMap);
                } else {
                    result.put(e.getTagName(), e.getTextContent().trim());
                }
            }

        }
        return result;
    }
}
