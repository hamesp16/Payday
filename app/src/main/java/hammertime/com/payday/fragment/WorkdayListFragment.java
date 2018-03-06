package hammertime.com.payday.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hammertime.com.payday.R;
import hammertime.com.payday.data.Workday;

public class WorkdayListFragment extends Fragment
{
    private RecyclerView workdayRecyclerView;
    private WorkdayAdapter adapter;
    private FloatingActionButton addWorkdayFab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_workday_list, container, false);

        workdayRecyclerView = view.findViewById(R.id.workday_recycler_view);
        workdayRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        addWorkdayFab = view.findViewById(R.id.workday_list_fab);
        addWorkdayFab.setOnClickListener(new View.OnClickListener()
             {
                 @Override
                 public void onClick(View v)
                 {
                     Fragment newCase = new WorkdayFragment();
                     FragmentTransaction transaction=getFragmentManager().beginTransaction();
                     transaction.replace(R.id.fragment_container,newCase);
                     transaction.addToBackStack(null);
                     transaction.commit();
                 }
             }
        );

        return view;
    }


    private class WorkdayHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Workday workday;

        public WorkdayHolder(LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.list_item_workday, parent, false));
        }

        public void bind(Workday workday)
        {
            this.workday = workday;
        }

        @Override
        public void onClick(View v)
        {

        }
    }

    private class WorkdayAdapter extends RecyclerView.Adapter<WorkdayHolder>
    {
        private List<Workday> workdayList;

        public WorkdayAdapter(List<Workday> workdayList)
        {
            this.workdayList = workdayList;
        }


        @NonNull
        @Override
        public WorkdayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new WorkdayHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull WorkdayHolder holder, int position)
        {
            Workday workday = workdayList.get(position);
            holder.bind(workday);
        }

        @Override
        public int getItemCount()
        {
            return workdayList.size();
        }
    }
}