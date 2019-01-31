package Join.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Join.service.JoinService;

@Service
public class ServiceImpl implements JoinService{

	@Resource(name="joinDao")
	private JoinDAO joinDao;
	//private Logger log = (Logger) LoggerFactory.getLogger(getClass());
	
	/*@Autowired
	private JoinDAO joinDao;*/
	
	//아이디 중복 확인하기
	/*@Override
	public HashMap<String, Object> getId(HashMap<String, Object> params) {
	
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> getList = joinDao.selectById(params);
		result.put("data", getList);
		
		System.out.println("select해온 값은 : "+getList);
		return result;
	}*/

	@Override
	public HashMap<String, Object> memberInsert(HttpServletRequest request, HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = new HashMap<String, Object>();
		try{
			//HashMap<String, Object> getList = joinDao.selectById(params);
			String str = joinDao.selectById(params);
			System.out.println("str의 값 : "+str);
			if(str == null){
				int resultCnt=0;
				resultCnt = joinDao.memberInsert(params);
				System.out.println("resultCnt 값은 : "+resultCnt);
					if(resultCnt > 0){
						result.put("code", "000");
						result.put("data", "회원가입 되었습니다");
					}else{
						result.put("code", "001");
						result.put("data", "회원가입에 실패했습니다. 다시 회원가입해주세요");
					}
			}else{
				result.put("code", "002");
				result.put("data", "아이디가 중복됩니다. 다른 아이디를 입력해주세요");
			}//else
		}catch(RuntimeException e){
			e.printStackTrace();
		}catch(Exception e){
			result.put("code", "999");
			result.put("data", e.getMessage());
		}
		return result;
	}
	
	
}
