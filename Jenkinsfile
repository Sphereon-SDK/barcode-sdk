node {

    // Checkout code from repository
    stage('Checkout source') {
        checkout scm
    }

    stage('Generate html-docs code') {
		withMaven(
				// Maven installation declared in the Jenkins "Global Tool Configuration"
				maven: 'M3')
			{

            // Run the maven build (works on both linux and windows)
			sh "mvn clean install -P html-docs"

		}
		// withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
	}
	
    stage('Generate javascript code') {
		withMaven(
				// Maven installation declared in the Jenkins "Global Tool Configuration"
				maven: 'M3')
			{

            // Run the maven build (works on both linux and windows)
			sh "mvn clean install -P javascript"

		}
		// withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
	}
	
    stage('Generate and build java8-okhttp-gson code') {
		withMaven(
				// Maven installation declared in the Jenkins "Global Tool Configuration"
				maven: 'M3')
			{

            // Run the maven build (works on both linux and windows)
			sh "mvn clean install -P java8-okhttp-gson"

		}
		
		dir("java8-okhttp-gson"){
			withMaven(
					// Maven installation declared in the Jenkins "Global Tool Configuration"
					maven: 'M3')
				{

				// Run the maven build (works on both linux and windows)
				sh "mvn clean install"

			}
		}
		// withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
	}

    stage('Generate java8-jersey2 code') {
		withMaven(
				// Maven installation declared in the Jenkins "Global Tool Configuration"
				maven: 'M3')
			{

            // Run the maven build (works on both linux and windows)
			sh "mvn clean install -P java8-jersey2"

		}
		dir("java8-jersey2"){
			withMaven(
					// Maven installation declared in the Jenkins "Global Tool Configuration"
					maven: 'M3')
				{

				// Run the maven build (works on both linux and windows)
				sh "mvn clean install"

			}
		}
		// withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
	}
	
    stage('Generate csharp-net45 code') {
		withMaven(
				// Maven installation declared in the Jenkins "Global Tool Configuration"
				maven: 'M3')
			{

            // Run the maven build (works on both linux and windows)
			sh "mvn clean install -P csharp-net45"

		}
		// withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
	}
	
}

