package lv.bizapps.textfileassetproba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.view.Menu;
import android.widget.TextView;

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
