package Join.service;

import Member.MemberDTO;

public interface JoinService {
	public String getId(String id);
	public void insert(MemberDTO member);
}
