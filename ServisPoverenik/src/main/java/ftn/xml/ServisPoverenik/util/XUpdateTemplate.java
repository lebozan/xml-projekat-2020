package ftn.xml.ServisPoverenik.util;

import org.exist.xupdate.XUpdateProcessor;

public class XUpdateTemplate {

    /*
     * There are two instructions in XUpdate that support insertion of nodes:
     * xupdate:insert-before and xupdate:insert-after. Both elements have a required
     * select attribute, which specifies the node selected by an XPath expression.
     * This select expression must evaluate to a node-set. The appendix of before
     * and after to the definition of insert is meant to specify the direction
     * where, in relation to the selected context node, the new node will be
     * inserted.
     *
     */

    public static String insertAfter(String targetNamespace) {

        return "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS + "\" xmlns=\""
                + targetNamespace + "\">" + "<xu:insert-after select=\"%1$s\">%2$s</xu:insert-after>"
                + "</xu:modifications>";

    }
    /*
     * The xupdate:insert-before inserts the given node as the preceding sibling of
     * the selected context node, where xupdate:insert-after inserts the given node
     * as the following sibling of the selected context node.
     */

    public static String insertBefore(String targetNamespace) {
        return "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS + "\" xmlns=\""
                + targetNamespace + "\">" + "<xu:insert-before select=\"%1$s\">%2$s</xu:insert-before>"
                + "</xu:modifications>";
    }
    /*
     * The xupdate:append element allows a node to be created and appended as a
     * child of the context node. An xupdate:append element must have a select
     * attribute which selects the context node as the parent of the new child node.
     * The select expression must evaluate to a node-set of element nodes. The
     * optional child attribute specifies the position of the newly appended child
     * node. The child expression must evaluate to an Integer value. If this
     * attribute is omitted, the new child is appended as the last child of the
     * selected context node.
     */

    public static String append(String targetNamespace) {
        return "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS + "\" xmlns=\""
                + targetNamespace + "\">" + "<xu:append select=\"%1$s\" child=\"last()\">%2$s</xu:append>"
                + "</xu:modifications>";
    }

    /*
     * The xupdate:update element can be used to update the content of existing
     * nodes. An xupdate:update element must have a select attribute, which selects
     * the context node for update. This select expression must evaluate to a
     * node-set.
     */
    public static String update(String targetNamespace) {
        String update = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
                + "\" xmlns=\"" + targetNamespace + "\">" + "<xu:update select=\"%1$s\">%2$s</xu:update>"
                + "</xu:modifications>";
        return update;
    }

    /*
     * The xupdate:remove element allows a node to be removed from the result tree.
     * The xupdate:remove element has a required select attribute, which specifies
     * the node selected by an XPath expression. The select expression must evaluate
     * to a node-set.
     */
    public static String remove(String targetNamespace) {
        return "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS + "\" xmlns=\""
                + targetNamespace + "\">" + "<xu:remove select=\"%1$s\"/>" + "</xu:modifications>";
    }
}
