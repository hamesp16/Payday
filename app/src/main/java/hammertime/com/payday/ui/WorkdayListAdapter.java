package hammertime.com.payday.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hammertime.com.payday.R;
import hammertime.com.payday.data.Workday;

public class WorkdayListAdapter extends RecyclerView.Adapter<WorkdayListAdapter.WorkdayHolder>
{
    public class WorkdayHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView day;
        private TextView date;
        private TextView timeWorked;
        private TextView salary;
        private TextView note;
        private TextView hoursWorked;
        private TextView unpaidBreak;

        WorkdayHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            day = itemView.findViewById(R.id.item_day_text_view);
            date = itemView.findViewById(R.id.item_date_text_view);
            timeWorked = itemView.findViewById(R.id.item_time_worked_text_view);
            salary = itemView.findViewById(R.id.item_salary_text_view);
            note = itemView.findViewById(R.id.item_note_text_view);
            hoursWorked = itemView.findViewById(R.id.item_hours_worked_text_view);
            unpaidBreak = itemView.findViewById(R.id.item_unpaid_break_text_view);
        }

        //TODO: when workday is clicked go to edit page
        @Override
        public void onClick(View v)
        {
            Toast.makeText(v.getContext(),
                    "Workday clicked!",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private final LayoutInflater inflater;
    private List<Workday> workdayList;
    private Workday currentWorkday;

    WorkdayListAdapter(Context context)
    {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WorkdayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.list_item_workday, parent,false);
        return new WorkdayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkdayHolder holder, int position)
    {
        currentWorkday = workdayList.get(position);

        holder.day.setText("ONS");
        holder.date.setText("01.03.2018");
        holder.timeWorked.setText(String.valueOf(currentWorkday.getHoursWorked()));
        holder.salary.setText("1600,-");
        holder.note.setText(currentWorkday.getNote());
        holder.hoursWorked.setText(String.valueOf(currentWorkday.getHoursWorked()));
        holder.unpaidBreak.setText(String.valueOf(currentWorkday.getUnpaidBreak()));
    }

    void setWorkdayList(List<Workday> workdays)
    {
        workdayList = workdays;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount()
    {
        if (workdayList != null)
        {
            return workdayList.size();
        }
        else
        {
            return 0;
        }
    }
}
