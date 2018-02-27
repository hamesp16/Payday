package hammertime.com.payday.activity;

import hammertime.com.payday.fragment.WorkdayFragment;
import android.support.v4.app.Fragment;

public class WorkdayActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {
        return new WorkdayFragment();
    }
}
