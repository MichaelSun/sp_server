package com.sp.domain



import org.junit.*
import grails.test.mixin.*

@TestFor(SubAppItemController)
@Mock(SubAppItem)
class SubAppItemControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/subAppItem/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.subAppItemInstanceList.size() == 0
        assert model.subAppItemInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.subAppItemInstance != null
    }

    void testSave() {
        controller.save()

        assert model.subAppItemInstance != null
        assert view == '/subAppItem/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/subAppItem/show/1'
        assert controller.flash.message != null
        assert SubAppItem.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/subAppItem/list'

        populateValidParams(params)
        def subAppItem = new SubAppItem(params)

        assert subAppItem.save() != null

        params.id = subAppItem.id

        def model = controller.show()

        assert model.subAppItemInstance == subAppItem
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/subAppItem/list'

        populateValidParams(params)
        def subAppItem = new SubAppItem(params)

        assert subAppItem.save() != null

        params.id = subAppItem.id

        def model = controller.edit()

        assert model.subAppItemInstance == subAppItem
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/subAppItem/list'

        response.reset()

        populateValidParams(params)
        def subAppItem = new SubAppItem(params)

        assert subAppItem.save() != null

        // test invalid parameters in update
        params.id = subAppItem.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/subAppItem/edit"
        assert model.subAppItemInstance != null

        subAppItem.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/subAppItem/show/$subAppItem.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        subAppItem.clearErrors()

        populateValidParams(params)
        params.id = subAppItem.id
        params.version = -1
        controller.update()

        assert view == "/subAppItem/edit"
        assert model.subAppItemInstance != null
        assert model.subAppItemInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/subAppItem/list'

        response.reset()

        populateValidParams(params)
        def subAppItem = new SubAppItem(params)

        assert subAppItem.save() != null
        assert SubAppItem.count() == 1

        params.id = subAppItem.id

        controller.delete()

        assert SubAppItem.count() == 0
        assert SubAppItem.get(subAppItem.id) == null
        assert response.redirectedUrl == '/subAppItem/list'
    }
}
