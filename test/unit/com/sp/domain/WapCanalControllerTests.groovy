package com.sp.domain



import org.junit.*
import grails.test.mixin.*

@TestFor(WapCanalController)
@Mock(WapCanal)
class WapCanalControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/wapCanal/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.wapCanalInstanceList.size() == 0
        assert model.wapCanalInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.wapCanalInstance != null
    }

    void testSave() {
        controller.save()

        assert model.wapCanalInstance != null
        assert view == '/wapCanal/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/wapCanal/show/1'
        assert controller.flash.message != null
        assert WapCanal.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/wapCanal/list'

        populateValidParams(params)
        def wapCanal = new WapCanal(params)

        assert wapCanal.save() != null

        params.id = wapCanal.id

        def model = controller.show()

        assert model.wapCanalInstance == wapCanal
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/wapCanal/list'

        populateValidParams(params)
        def wapCanal = new WapCanal(params)

        assert wapCanal.save() != null

        params.id = wapCanal.id

        def model = controller.edit()

        assert model.wapCanalInstance == wapCanal
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/wapCanal/list'

        response.reset()

        populateValidParams(params)
        def wapCanal = new WapCanal(params)

        assert wapCanal.save() != null

        // test invalid parameters in update
        params.id = wapCanal.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/wapCanal/edit"
        assert model.wapCanalInstance != null

        wapCanal.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/wapCanal/show/$wapCanal.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        wapCanal.clearErrors()

        populateValidParams(params)
        params.id = wapCanal.id
        params.version = -1
        controller.update()

        assert view == "/wapCanal/edit"
        assert model.wapCanalInstance != null
        assert model.wapCanalInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/wapCanal/list'

        response.reset()

        populateValidParams(params)
        def wapCanal = new WapCanal(params)

        assert wapCanal.save() != null
        assert WapCanal.count() == 1

        params.id = wapCanal.id

        controller.delete()

        assert WapCanal.count() == 0
        assert WapCanal.get(wapCanal.id) == null
        assert response.redirectedUrl == '/wapCanal/list'
    }
}
