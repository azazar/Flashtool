package gui.tools;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.ta.parsers.TAUnit;

import flashsystem.Flasher;

public class WriteTAJob extends Job {

    Flasher flash = null;
    TAUnit ta = null;
    boolean canceled = false;
    boolean success = false;

    public boolean writeSuccess() {
        return success;
    }

    public WriteTAJob(String name) {
        super(name);
    }

    public void setFlash(Flasher f) {
        flash = f;
    }

    public void setTA(TAUnit t) {
        ta = t;
    }

    protected IStatus run(IProgressMonitor monitor) {
        try {
            flash.writeTA(2, ta);
            success = true;
            return Status.OK_STATUS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return Status.CANCEL_STATUS;
        }
    }
}
