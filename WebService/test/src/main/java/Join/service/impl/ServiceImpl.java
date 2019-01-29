package Join.service.impl;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Join.service.JoinService;
import Member.MemberDTO;

@Service
public class ServiceImpl implements JoinService{

	/*@Resource(name="JoinDAO")
	private JoinDAO joindao;*/

	//private Logger log = (Logger) LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JoinDAO joinDao;
	
	//아이디 중복 확인하기
	@Override
	public HashMap<String, Object> getId(HashMap<String, Object> params) {
	
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> getList = joinDao.getId(params);
		result.put("data", getList);
		
		System.out.println("select해온 값은 : "+getList);
		return result;
	}

	@Override
	public HashMap<String, Object> memberInsert(HttpServletRequest request, HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try{
			int resultCnt=0;
			resultCnt = joinDao.memberInsert(params);
			System.out.println("resultCnt 값은 : "+resultCnt);
			if(resultCnt > 0){
				result.put("code", "000");
				result.put("data", "회원가입 되었습니다");
			}else{
				result.put("code", "001");
				result.put("data", "회원가입이 실패했습니다. 다시 회원가입해주세요");
			}
		}catch(Exception e){
			result.put("code", "999");
			result.put("data", e.getMessage());
		}
		return result;
	}
	
	
}
