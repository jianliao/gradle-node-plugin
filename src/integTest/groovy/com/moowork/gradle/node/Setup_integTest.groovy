package com.moowork.gradle.node

import com.moowork.gradle.AbstractIntegTest

class Setup_integTest
    extends AbstractIntegTest
{
    private final static OS_NAME = System.getProperty( 'os.name' )

    def cleanup()
    {
        System.setProperty( 'os.name', OS_NAME )
    }

    def 'setup node'()
    {
        given:
        writeBuild( '''
            apply plugin: 'com.moowork.node'

            node {
                version = "0.10.33"
                download = false
            }
        ''' )

        when:
        def result = runTasksSuccessfully( 'nodeSetup' )

        then:
        result.wasExecuted( 'nodeSetup' )
    }

    def 'setup node (download)'()
    {
        given:
        writeBuild( '''
            apply plugin: 'com.moowork.node'

            node {
                version = "0.10.33"
                download = true
            }
        ''' )

        when:
        def result = runTasksSuccessfully( 'nodeSetup' )

        then:
        result.wasExecuted( 'nodeSetup' )
    }

    def 'setup node (windows)'()
    {
        System.setProperty( 'os.name', 'Windows' )

        given:
        writeBuild( '''
            apply plugin: 'com.moowork.node'

            node {
                version = "0.10.33"
                download = false
            }
        ''' )

        when:
        def result = runTasksSuccessfully( 'nodeSetup' )

        then:
        result.wasExecuted( 'nodeSetup' )
    }

    def 'setup node (windows download)'()
    {
        System.setProperty( 'os.name', 'Windows' )

        given:
        writeBuild( '''
            apply plugin: 'com.moowork.node'

            node {
                version = "0.10.33"
                download = true
            }
        ''' )

        when:
        def result = runTasksSuccessfully( 'nodeSetup' )

        then:
        result.wasExecuted( 'nodeSetup' )
    }
}
