package day05;

public class Ecu {
	String code;
	int available_distance; //주행가능거리
	double battery_capacity; // 현재배터리 용량
	int indoor_temp; //실내온도
	int outdoor_temp; //실외온도
	int speed; //현재 주행 속도
	int charging_status; //충전상태 0 default 충전X 1 충전중
	int charging_after_distance; //최근 충전 이후 주행거리
	double consumption_after_charging; //최근 충전 배터리 사용량
	int monthly_distance; // 월간 주행거리
	double monthly_battery_use; // 월간 배터리 사용량
	double monthly_fuel_efficiency; //월간 전비(연비)
	int cumulative_mileage ; //누적 주행거리
	int charge_amount; //충전시 설정 용량
	float latitude; //차량의 위도
	float longtitude; //차량의 경도
	String model_name; //차량의 모델넘버 ex ModelS 90D
	String user_name; // 로그인한 사람의 이메일
	double charging_after_fuel_efficiency; //최근 충전 이후 전비(연비)
	
	
	
	
}
