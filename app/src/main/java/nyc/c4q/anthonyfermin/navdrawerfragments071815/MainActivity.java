package nyc.c4q.anthonyfermin.navdrawerfragments071815;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerList = (ListView) findViewById(R.id.navList);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        addDrawerItems();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fTransaction = fragmentManager.beginTransaction();
        fTransaction.replace(R.id.content_frame, new HomeFragment()).commit();

    }

    private void addDrawerItems() {
        String[] ndArray = {"Home Screen", "Button Press Counter"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ndArray);
        mDrawerList.setAdapter(mAdapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragment = null;
                switch (position) {
                    case 0: {
                        fragment = new HomeFragment();
                        break;
                    }
                    case 1: {
                        fragment = new ButtonPressFragment();
                        break;
                    }
                    default:
                        break;
                }

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fTransaction = fragmentManager.beginTransaction();
                fTransaction.replace(R.id.content_frame, fragment).commit();

                drawerLayout.closeDrawers();
            }
        });
    }
}