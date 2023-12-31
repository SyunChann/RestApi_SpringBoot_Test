package nexmore.RestApi.swagger.controller;

import nexmore.RestApi.swagger.dto.UserRes;
import nexmore.RestApi.swagger.dto.UserReq;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

//	@Api: 해당 컨트롤러에 내용을 설정
//	@ApiImpicitParams: 컨트롤러에 매핑될 파라미터들에 설정
//	@ApiImpicitParam: 매핑될 파라미터 하나의 내용을 설정
//	@ApiResponse: 응답 코드에 대한 설9명
//	@ApiOperation: 매핑 메소드에 대한 설명

@RequestMapping("/api")
@RestController
@Api(tags = {"API 정보를 제공하는 Controller"})
public class ApiController {
	
	@GetMapping("/hello")
	public String Hello() { 
		return "hello";
	}
	
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "x", value = "x 값", required = true, dataType = "int", paramType = "path")
		, @ApiImplicitParam(name = "y", value = "y 값", required = true, dataType = "int", paramType = "query")
	})
	@GetMapping("/plus/{x}")
	public int plus(@PathVariable int x, @RequestParam int y) {
		return x + y;
	}
	
	
	@ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일때")
	@ApiOperation(value = "사용자의 이름과 나이를 리턴하는 메소드")
	@GetMapping("/user")
	public UserRes user(UserReq userReq){
        return new UserRes(userReq.getName(), userReq.getAge());
    }

    @PostMapping("/user")
    public UserRes userPost(@RequestBody UserReq req){
        return new UserRes(req.getName(), req.getAge());
    }
	
	
}
