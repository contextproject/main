package snippet;

import java.util.Set;

public class CommentIntensitySeeker {

	
	protected int getStartTime(Set<Comment> coms,int duration){
		
		return 0;
	}
	
	public TimedSnippet seek(Set<Comment> coms){
		
		return new TimedSnippet(getStartTime(coms,TimedSnippet.getDefaultDuration()));
		
	}
	
	
	
	public TimedSnippet seekDuration(Set<Comment> coms,int duration){
		return new TimedSnippet(getStartTime(coms,duration),duration);
	}
	
}
