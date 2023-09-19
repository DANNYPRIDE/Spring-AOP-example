# Spring-AOP-example
AOP를 활용한 두 가지 샘플 예제 입니다. 
### 1. Lock
`GET localhost:8080`
엔드포인트는 @Lock annotation을 포함하며 동시 호출로부터 안전합니다. (동시 호출시 예외 발생) 
1. GlobalLock 은 Custom Annotation입니다.
2. 해당 Annotation을 관리하는 GlobalLockAspect 클래스가 존재합니다.
3. 해당 예제에서는 Lock 자료구조로 ConcurrentMap을 사용합니다. 

### 2. RateLimit
`GET localhost:8080/demo` 엔드포인트는 @RateLimit annotation을 포함하며 최대 호출 수 (500)이 설정되어있습니다.
1. RateLimit은 Custom Annotation입니다.
2. 해당 Annotation을 관리하는 RateLimitAspect 클래스가 존재합니다.
3. 해당 예제에서는 RateLimit 자료구조로 ConcurrentMap을 사용합니다.
