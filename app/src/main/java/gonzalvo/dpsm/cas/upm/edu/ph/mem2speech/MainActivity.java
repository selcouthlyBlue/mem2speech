package gonzalvo.dpsm.cas.upm.edu.ph.mem2speech;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import gonzalvo.dpsm.cas.upm.edu.ph.mem2speech.canvas.CanvasFragment;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1;
    private static final int GALLERY_REQUEST = 2;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_canvas:
                    fragmentTransaction.replace(R.id.content, new CanvasFragment(), "CANVAS_FRAGMENT");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_image:
                    fragmentTransaction.replace(R.id.content, new ImageFragment(), "IMAGE_FRAGMENT");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_camera:
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, CAMERA_REQUEST);
                    }
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CAMERA_REQUEST:
                break;
            case GALLERY_REQUEST:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private int currentlyActiveFragment;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_convert:
                getMachineReadableText();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_canvas);
    }

    public void getMachineReadableText() {
        final HandwrittenTextSourceFragment handwrittenTextSourceFragment = (HandwrittenTextSourceFragment) getSupportFragmentManager().findFragmentByTag("CANVAS_FRAGMENT");
        new ToText(MainActivity.this).execute(handwrittenTextSourceFragment.getImage());
    }
}
