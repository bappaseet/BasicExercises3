package com.coreservlets.basicsexercises1;

import java.io.IOException;
import java.net.MalformedURLException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/** Loads a simple layout from main.xml. None of the GUI
 *  controls have any behavior, and strings are taken from strings.xml.
 *  <p>
 *  From <a href="http://www.coreservlets.com/android-tutorial/">
 *  the coreservlets.com Android programming tutorial series</a>.
 */

public class DetailPageActivity extends Activity {
    /** Initializes the app when it is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Bundle data = getIntent().getExtras();
        if (data == null) {
           return;
        }
      //  byte[] byteArray = data.getByteArray("picture");
     //   Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        String value2 = data.getString("bmp_img");
        Bitmap bmp = null;
		try {
			bmp = BitmapFactory.decodeStream(new java.net.URL(value2).openStream());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        ImageView image = (ImageView) findViewById(R.id.imageView1);

        image.setImageBitmap(bmp);
        TextView textview1 = (TextView) findViewById(R.id.tvName1);
        String value1 = data.getString("Value1");
        textview1.setText(value1);
        

    }
}