package kkmapp.application.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TreeSet;

public class ExtendedProperties extends Properties{
    private static class StripFirstLineStream extends FilterOutputStream {

        private boolean firstLineSeen = false;
        public StripFirstLineStream(final OutputStream out) {
            super(out);
        }

        @Override
        public void write(final int b) throws IOException {
            if (firstLineSeen) {
                super.write(b);
            } else if (b == '\n') {
                firstLineSeen = true;
            }
        }
    }

    private static class StripSecondLineStream extends FilterOutputStream {

        private boolean firstLineObserver = true;
        private boolean secondLineObserver = false;

        public StripSecondLineStream(final OutputStream out) {
            super(out);
        }

        @Override
        public void write(final int b) throws IOException {

        	if((b == '\n') && firstLineObserver) {
        		firstLineObserver = false;
        		secondLineObserver = true;
        	}

        	else if(secondLineObserver) {
        		if(b == '\n') {
        			secondLineObserver = false;
        		}
        	}

        	else {
        		super.write(b);
        	}
        }
    }

    @Override
    public synchronized Enumeration<Object> keys() {
        return Collections.enumeration(new TreeSet<>(super.keySet()));
    }

    public void storeWithoutTimeStamp(final OutputStream out, final String comments)
            throws IOException {
    	if((comments == null) || (comments.equals(""))) {
    		super.store(new StripFirstLineStream(out), null);
    	}

    	else {
    		super.store(new StripSecondLineStream(out), comments);
    	}
    }

    public void store1(final OutputStream out, final String comments)
        throws IOException {
        if((comments == null) || (comments.equals("")))
        super.store(new StripSecondLineStream(out), comments);
    }
}
