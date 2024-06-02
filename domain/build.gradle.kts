plugins {
    id ("java-library")
    id ("org.jetbrains.kotlin.jvm")
    id("com.google.devtools.ksp")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Retrofit.RETROFIT_2)
    implementation(Jetpack.PAGING_TEST)

    testImplementation(Test.JUNIT_5_API)
    testRuntimeOnly(Test.JUNIT_5_ENGINE)
    testImplementation(Test.JUNIT_5_PARAMS)
    testImplementation(Test.JUNIT_4)
    testRuntimeOnly(Test.JUNIT_5_VINTAGE)
    testImplementation(Test.MOCKK)
    testImplementation(Test.TEST_KOTLIN)
}