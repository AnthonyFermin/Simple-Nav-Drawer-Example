package nyc.c4q.anthonyfermin.navdrawerfragments071815;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by c4q-anthonyf on 7/18/15.
 */

public class ButtonPressFragment extends Fragment {

    Button button;
    TextView numOfPresses;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_button_press, container, false);

        button = (Button) root.findViewById(R.id.button);
        numOfPresses = (TextView) root.findViewById(R.id.numOfPressesTv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(numOfPresses.getText().toString());
                num++;
                numOfPresses.setText(num + "");
            }
        });

        return root;

    }
}
