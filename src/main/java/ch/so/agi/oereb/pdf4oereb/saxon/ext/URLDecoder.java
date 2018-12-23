package ch.so.agi.oereb.pdf4oereb.saxon.ext;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import net.sf.saxon.expr.XPathContext;
import net.sf.saxon.lib.ExtensionFunctionCall;
import net.sf.saxon.lib.ExtensionFunctionDefinition;
import net.sf.saxon.om.LazySequence;
import net.sf.saxon.om.Sequence;
import net.sf.saxon.om.StructuredQName;
import net.sf.saxon.trans.XPathException;
import net.sf.saxon.value.Int64Value;
import net.sf.saxon.value.AnyURIValue;
import net.sf.saxon.value.IntegerValue;
import net.sf.saxon.value.SequenceType;
import net.sf.saxon.value.StringValue;

public class URLDecoder extends ExtensionFunctionDefinition {

	@Override
	public StructuredQName getFunctionQName() {
        return new StructuredQName("oereb", "http://oereb.agi.so.ch", "decodeURL");
	}

	@Override
	public SequenceType[] getArgumentTypes() {
        return new SequenceType[]{SequenceType.SINGLE_STRING};
	}

	@Override
	public SequenceType getResultType(SequenceType[] suppliedArgumentTypes) {
        return SequenceType.SINGLE_STRING;
	}

	@Override
	public ExtensionFunctionCall makeCallExpression() {
		return new ExtensionFunctionCall() {
            @Override
            public Sequence call(XPathContext context, Sequence[] arguments) throws XPathException {
                String inputUrl = ((LazySequence) arguments[0]).materialize().getStringValue();
    			String decodedUrl;
				try {
					decodedUrl = java.net.URLDecoder.decode(inputUrl, "UTF-8");
	    			URI resultUri = new URI(decodedUrl);
	                return StringValue.makeStringValue(resultUri.toString());
				} catch (UnsupportedEncodingException | URISyntaxException e) {
					e.printStackTrace();
				}
				return null;                
            }
        };	
    }
}
