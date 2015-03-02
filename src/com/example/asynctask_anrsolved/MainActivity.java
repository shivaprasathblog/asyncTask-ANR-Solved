package com.example.asynctask_anrsolved;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity 
{

	Button b;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button1);
        
        b.setOnClickListener(new OnClickListener()
        {
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				
				new SampleTask().execute();
				
			}
		});
    }
    
    private class SampleTask extends AsyncTask<Void, Integer, Void>
	{
    	
    	
    	@Override
    	protected void onPreExecute()
    	{
    		
    		
    	}

		@Override
		protected Void doInBackground(Void... params)
		{
			for (int i = 0; i < 10000; i++) 
			{
				try 
				{
					Thread.sleep(1000);
					publishProgress(i); 				
				} 
				catch (InterruptedException e) 
				{
					
				}
			}
			return null;
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) 
		{
			String toastval=( Integer.toString(values[0].intValue()));		
			
			Toast.makeText(getBaseContext(),"ANR Solved "+ toastval,Toast.LENGTH_LONG).show();
		}	
		
		
		@Override
		protected void onPostExecute(Void result)
		{
					
		}		
    }

}
