package com.sp.domain



import org.junit.*
import grails.test.mixin.*

@TestFor(CanalController)
@Mock(Canal)
class CanalControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/canal/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.canalInstanceList.size() == 0
        assert model.canalInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.canalInstance != null
    }

    void testSave() {
        controller.save()

        assert model.canalInstance != null
        assert view == '/canal/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/canal/show/1'
        assert controller.flash.message != null
        assert Canal.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/canal/list'

        populateValidParams(params)
        def canal = new Canal(params)

        assert canal.save() != null

        params.id = canal.id

        def model = controller.show()

        assert model.canalInstance == canal
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/canal/list'

        populateValidParams(params)
        def canal = new Canal(params)

        assert canal.save() != null

        params.id = canal.id

        def model = controller.edit()

        assert model.canalInstance == canal
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/canal/list'

        response.reset()

        populateValidParams(params)
        def canal = new Canal(params)

        assert canal.save() != null

        // test invalid parameters in update
        params.id = canal.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/canal/edit"
        assert model.canalInstance != null

        canal.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/canal/show/$canal.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        canal.clearErrors()

        populateValidParams(params)
        params.id = canal.id
        params.version = -1
        controller.update()

        assert view == "/canal/edit"
        assert model.canalInstance != null
        assert model.canalInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/canal/list'

        response.reset()

        populateValidParams(params)
        def canal = new Canal(params)

        assert canal.save() != null
        assert Canal.count() == 1

        params.id = canal.id

        controller.delete()

        assert Canal.count() == 0
        assert Canal.get(canal.id) == null
        assert response.redirectedUrl == '/canal/list'
    }
}
