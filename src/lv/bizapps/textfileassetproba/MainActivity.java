package lv.bizapps.textfileassetproba;

import java.io.*;
import android.os.*;
import android.app.*;
import android.content.res.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView tv = (TextView)findViewById(R.id.textView1);
		//tv.setText(Html.fromHtml("<b>sdfsdfsdf</b> sdfsdfsdfsdf"));

		AssetManager am = getAssets();
		try {
			InputStream is = am.open("file.txt");

			InputStreamReader inputreader = new InputStreamReader(is);
		    BufferedReader bufferedreader = new BufferedReader(inputreader);

		    String line;
		    while((line = bufferedreader.readLine()) != null) {
		    	tv.append(line);
		    	tv.append("\n");
		    }
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}
}
