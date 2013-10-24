package com.sp.domain



import org.junit.*
import grails.test.mixin.*

@TestFor(SdkCanalController)
@Mock(SdkCanal)
class SdkCanalControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/sdkCanal/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.sdkCanalInstanceList.size() == 0
        assert model.sdkCanalInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.sdkCanalInstance != null
    }

    void testSave() {
        controller.save()

        assert model.sdkCanalInstance != null
        assert view == '/sdkCanal/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/sdkCanal/show/1'
        assert controller.flash.message != null
        assert SdkCanal.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/sdkCanal/list'

        populateValidParams(params)
        def sdkCanal = new SdkCanal(params)

        assert sdkCanal.save() != null

        params.id = sdkCanal.id

        def model = controller.show()

        assert model.sdkCanalInstance == sdkCanal
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/sdkCanal/list'

        populateValidParams(params)
        def sdkCanal = new SdkCanal(params)

        assert sdkCanal.save() != null

        params.id = sdkCanal.id

        def model = controller.edit()

        assert model.sdkCanalInstance == sdkCanal
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/sdkCanal/list'

        response.reset()

        populateValidParams(params)
        def sdkCanal = new SdkCanal(params)

        assert sdkCanal.save() != null

        // test invalid parameters in update
        params.id = sdkCanal.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/sdkCanal/edit"
        assert model.sdkCanalInstance != null

        sdkCanal.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/sdkCanal/show/$sdkCanal.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        sdkCanal.clearErrors()

        populateValidParams(params)
        params.id = sdkCanal.id
        params.version = -1
        controller.update()

        assert view == "/sdkCanal/edit"
        assert model.sdkCanalInstance != null
        assert model.sdkCanalInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/sdkCanal/list'

        response.reset()

        populateValidParams(params)
        def sdkCanal = new SdkCanal(params)

        assert sdkCanal.save() != null
        assert SdkCanal.count() == 1

        params.id = sdkCanal.id

        controller.delete()

        assert SdkCanal.count() == 0
        assert SdkCanal.get(sdkCanal.id) == null
        assert response.redirectedUrl == '/sdkCanal/list'
    }
}
