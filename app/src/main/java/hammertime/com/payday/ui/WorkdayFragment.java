package hammertime.com.payday.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import hammertime.com.payday.R;

public class WorkdayFragment extends Fragment
{
    private EditText noteEditText;
    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_workday, container, false);

        noteEditText = view.findViewById(R.id.workday_note_edit_text);

        toolbar(view);


        return view;
    }

    private void toolbar(View view)
    {
        toolbar = view.findViewById(R.id.workday_toolbar);

        toolbar.setOnMenuItemClickListener(item ->
        {
            int id = item.getItemId();

            if (id == R.id.action_save)
            {
                Toast.makeText(view.getContext(),
                        "Save clicked!",
                        Toast.LENGTH_SHORT)
                        .show();
            }

            return WorkdayFragment.super.onOptionsItemSelected(item);
        });
        toolbar.setNavigationIcon(R.drawable.ic_clear_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(view.getContext(),
                        "Back icon clicked!",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
        toolbar.setTitle("Register workday");
        toolbar.inflateMenu(R.menu.register_workday_menu);
    }
}
