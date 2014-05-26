package jie.android.snakego.script;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public abstract class BaseScript {
	
	protected boolean loadFile(final String file) {
		try {
			return load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean loadString(final String str) {
		return load(new ByteArrayInputStream(str.getBytes()));
	}
	
	protected abstract boolean load(final InputStream is);
}
