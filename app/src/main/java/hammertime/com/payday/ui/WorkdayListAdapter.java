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
        private TextView dayTextView;
        private TextView dateTextView;
        private TextView timeWorkedTextView;
        private TextView salaryTextView;
        private TextView noteTextView;
        private TextView hoursWorkedTextView;
        private TextView unpaidBreakTextView;

        WorkdayHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            dayTextView = itemView.findViewById(R.id.item_day_text_view);
            dateTextView = itemView.findViewById(R.id.item_date_text_view);
            timeWorkedTextView = itemView.findViewById(R.id.item_time_worked_text_view);
            salaryTextView = itemView.findViewById(R.id.item_salary_text_view);
            noteTextView = itemView.findViewById(R.id.item_note_text_view);
            hoursWorkedTextView = itemView.findViewById(R.id.item_hours_worked_text_view);
            unpaidBreakTextView = itemView.findViewById(R.id.item_unpaid_break_text_view);
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
        Workday currentWorkday = workdayList.get(position);

        holder.dayTextView.setText("ONS");
        holder.dateTextView.setText("01.03.2018");
        holder.timeWorkedTextView.setText(String.valueOf("12 - 20"));
        holder.salaryTextView.setText("1600,-");
        holder.noteTextView.setText(currentWorkday.getNote());
        holder.hoursWorkedTextView.setText(String.valueOf(currentWorkday.getHoursWorked()));
        holder.unpaidBreakTextView.setText(String.valueOf(currentWorkday.getUnpaidBreak()) + " min");
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
