# Spring-AOP-example
Lock Implementation

Spring Aspect를 활용한 Lock입니다. 

1. GlobalLock 이라는 Custom Annotation을 만들었습니다.
2. GlobalLock annotation에 대응되는 Aspect가 존재합니다. java reflection을 활용해 annotation의 value를 활용합니다.
