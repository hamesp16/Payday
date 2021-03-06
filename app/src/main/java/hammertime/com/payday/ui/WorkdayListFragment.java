package hammertime.com.payday.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import hammertime.com.payday.R;
import hammertime.com.payday.viewmodel.WorkdayViewModel;

public class WorkdayListFragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_workday_list, container, false);

        toolbar(view);


        RecyclerView recyclerView = view.findViewById(R.id.workday_recycler_view);
        final WorkdayListAdapter adapter = new WorkdayListAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Get a new or existing ViewModel from the ViewModelProvider.
        WorkdayViewModel workdayViewModel = ViewModelProviders.of(this).get(WorkdayViewModel.class);

        // Add an observer on the LiveData returned by getAllWorkdays.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        workdayViewModel.getAllWorkdays().observe(this, workdays ->
        {
            //Update the cached copy of workdays in the adapter.
            adapter.setWorkdayList(workdays);
        });

        FloatingActionButton addWorkdayFab = view.findViewById(R.id.workday_list_fab);
        addWorkdayFab.setOnClickListener(v ->
                {
                    Fragment newCase = new WorkdayFragment();
                    FragmentTransaction transaction=getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container,newCase);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
        );

        return view;
    }

    private void toolbar(View view)
    {
        Toolbar toolbar = view.findViewById(R.id.workday_list_toolbar);

        toolbar.setOnMenuItemClickListener(item ->
        {
            int id = item.getItemId();

            if (id == R.id.action_sort)
            {
                Toast.makeText(view.getContext(),
                        "Sort clicked!",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else if (id == R.id.action_about_us)
            {
                Toast.makeText(view.getContext(),
                        "Settings clicked!",
                        Toast.LENGTH_SHORT)
                        .show();
            }

            return WorkdayListFragment.super.onOptionsItemSelected(item);
        });
        toolbar.setTitle(R.string.app_name);
        toolbar.inflateMenu(R.menu.main_menu);
    }
}