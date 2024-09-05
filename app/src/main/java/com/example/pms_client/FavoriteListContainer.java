package com.example.pms_client;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.provider.ContactsContract;
import android.provider.CallLog;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FavoriteListContainer extends AppCompatActivity {

    ListView favoriteContainer;

//    boolean isFavoriteView = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_container);

//        Intent serviceIntent = new Intent(this, OverlayService.class);
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            startForegroundService(serviceIntent);
//        } else {
//            startService(serviceIntent);
//        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                String title = (String) item.getTitle();
//
//                if(title.equals(getString(R.string.favorite_title))) {
//                    Toast.makeText(FavoriteListContainer.this, "1", Toast.LENGTH_SHORT).show();
//                }
//                if(title.equals(getString(R.string.history_title))) {
//                    Toast.makeText(FavoriteListContainer.this, "2", Toast.LENGTH_SHORT).show();
//                }
//                if(title.equals(getString(R.string.contacts_title))) {
//                    Toast.makeText(FavoriteListContainer.this, "3", Toast.LENGTH_SHORT).show();
//                }
//                return false;
//            }
//        });
        bottomNavigationView.findViewById(R.id.nav_favorites).setOnClickListener(v -> {

        });

        bottomNavigationView.findViewById(R.id.nav_history).setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(CallLog.Calls.CONTENT_URI);
//            intent.setData(Uri.parse(ContactsContract.Groups.FAVORITES));
            startActivity(intent);
        });

        bottomNavigationView.findViewById(R.id.nav_contacts).setOnClickListener(v -> {

//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(ContactsContract.Contacts.CONTENT_URI);
//            startActivity(intent);
            Intent intent = new Intent(FavoriteListContainer.this, SearchContactsContainer.class);
            startActivity(intent);
        });

        TextView addContactTextView = findViewById(R.id.favorite_add);
        addContactTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FavoriteListContainer.this, FavoriteAdd.class);
                startActivity(intent);
            }
        });

        favoriteContainer = (ListView) findViewById(R.id.container_favorite_list);
        favoriteContainer.setDivider(null);

        FavoriteListItem[] favoriteItems = new FavoriteListItem[] {
                new FavoriteListItem("田崎 幸治", "0761-55-3487", "勤務先", R.drawable.avatar_background),
                new FavoriteListItem("谷口 日野自動車", "155-455-1145", "携帯", R.drawable.green_button_background),
                new FavoriteListItem("谷口 日野自動車", "095-665-5744", "携帯", R.drawable.avatar_background),
                new FavoriteListItem("田崎 幸治", "0761-55-3487", "勤務先", R.drawable.green_button_background),
                new FavoriteListItem("谷口 日野自動車", "0265-336-122", "勤務先", R.drawable.avatar_background),
                new FavoriteListItem("田崎 幸治", "1202-055-1225", "携帯", R.drawable.avatar_background),
                new FavoriteListItem("谷口 日野自動車", "0123-55-2365", "携帯", R.drawable.green_button_background),
                new FavoriteListItem("谷口 日野自動車", "0761-55-3487", "勤務先", R.drawable.avatar_background),
                new FavoriteListItem("田崎 幸治", "0761-55-3487", "勤務先", R.drawable.green_button_background),
                new FavoriteListItem("谷口 日野自動車", "1-145-225-2336", "携帯", R.drawable.avatar_background),
                new FavoriteListItem("田崎 幸治", "0761-55-3487", "勤務先", R.drawable.green_button_background),
                new FavoriteListItem("谷口 日野自動車", "123-669-1215", "勤務先", R.drawable.avatar_background),
        };

        FavoriteAdapter adapter = new FavoriteAdapter(this, R.layout.favorite_list_item, favoriteItems);
        favoriteContainer.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

//        Intent serviceIntent = new Intent(this, OverlayService.class);
//        stopService(serviceIntent);
    }
}
