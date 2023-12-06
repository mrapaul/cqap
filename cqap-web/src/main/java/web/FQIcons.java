package web;

import com.vaadin.server.*;

public enum FQIcons implements FontIcon
{
    CLOSE(0Xf00d);

    private static final String fontFamily = "FontAwesome";
    private int codepoint;

    FQIcons(int codepoint) {
        this.codepoint = codepoint;
    }

    /**
     * Unsupported: {@link FontIcon} does not have a MIME type and is not a
     * {@link Resource} that can be used in a context where a MIME type would be
     * needed.
     */
    @Override
    public String getMIMEType() {
        throw new UnsupportedOperationException(FontIcon.class.getSimpleName()
                + " should not be used where a MIME type is needed.");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.ui.FontIcon#getFontFamily()
     */
    @Override
    public String getFontFamily() {
        return fontFamily;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.ui.FontIcon#getCodepoint()
     */
    @Override
    public int getCodepoint() {
        return codepoint;
    }

    @Override
    public String getHtml() {
        return "<span class=\"v-icon\" style=\"font-family: " + fontFamily
                + ";\">&#x" + Integer.toHexString(codepoint) + ";</span>";
    }
}
