package a2_bi12_009.studentman;

/**
 * @overview
 *           An interface representing all kinds of documents
 */
interface Document {
	/**
	 * @effects
	 *          returns a HTML string that represents the document in the format:
	 * 
	 *          <pre>
	 * &lt;html&gt;
	 * &lt;head&gt;&lt;title&gt;	title_here	&lt;/title&gt;
	 * &lt;body&gt;
	 *		body_here
	 * &lt;/body&gt;&lt;/html&gt;
	 *          </pre>
	 */
	public String toHtmlDoc();
}
