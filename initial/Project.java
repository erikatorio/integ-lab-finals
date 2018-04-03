public class Project {
	private String title;
	private ProjectMember leader;
	private String status;

	public Project(String title, ProjectMember leader, String status) {
		this.title = title;
		this.leader = leader;
		this.status = status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setLeader(ProjectMember leader) {
		this.leader = leader;
	}

	public ProjectMember getLeader() {
		return leader;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}