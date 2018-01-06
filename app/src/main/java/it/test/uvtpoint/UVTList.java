package it.test.uvtpoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UVTList extends Activity {
    private ListView mList;
    private List<UVTModel> uvts = new ArrayList<>();
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        mList = (ListView) findViewById(R.id.list_item);
        uvts.add(new UVTModel("Polytechnique de Sousse", 35.8354976, 10.6119685));
        uvts.add(new UVTModel("ISITCOM", 35.8576112, 10.5995346));
        uvts.add(new UVTModel("ENISO", 35.8236875, 10.5890661));
        uvts.add(new UVTModel("IHEC Sousse", 35.8316903, 10.5818135));

        String[] values = new String[uvts.size()];
        for (int i=0; i<uvts.size(); i++)
            values[i] = uvts.get(i).name();

        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent carte = new Intent(UVTList.this, Carte.class);
                carte.putExtra("name", uvts.get(position).name());
                carte.putExtra("latitude", uvts.get(position).latitude());
                carte.putExtra("longitude", uvts.get(position).longitude());
                startActivity(carte);
            }
        });
    }
}
